package pl.dmcs.jwlodarczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.jwlodarczyk.domain.Patient;
import pl.dmcs.jwlodarczyk.domain.PatientRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("patientDetailsService")
public class PatientDetailsService implements UserDetailsService {

    private PatientService patientService;

    @Autowired
    public PatientDetailsService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String login) {
        Patient patient = patientService.getPatientByLogin(login);
        List<GrantedAuthority> authorities = buildUserAuthority(patient.getRole());

        return new org.springframework.security.core.userdetails.User(
                patient.getLogin(),
                patient.getPassword(),
                patient.isEnabled(),
                true, true, true,
                authorities
        );
    }

    private List<GrantedAuthority> buildUserAuthority(Set<PatientRole> patientRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        for (PatientRole patientRole : patientRoles) {
            setAuths.add(new SimpleGrantedAuthority(patientRole.getRole()));
        }
        return new ArrayList<>(setAuths);
    }
}
