<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
    #navbar {
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        overflow: hidden;
    }

    #navbar a {
        float: left;
        display: block;
        color: #333;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    #navbar a:hover {
        background-color: #ddd;
        color: black;
    }

    .small-flag {
        width: 30px;
        height: auto;
        margin-right: 5px;
    }
</style>

<div id="navbar">
    <form id="langForm" action="" method="get">
        <a href="?lang=pl">
            <img src="https://flagicons.lipis.dev/flags/4x3/pl.svg" alt="Polish Flag" class="small-flag">
        </a>
        <a href="?lang=en" style="text-decoration: none">
            <img src="https://flagicons.lipis.dev/flags/4x3/gb.svg"
                 alt="English Flag"
                 class="small-flag">
        </a>
        <a href="?lang=es" style="text-decoration: none">
            <img src="https://flagicons.lipis.dev/flags/4x3/es.svg"
                 alt="Spanish Flag"
                 class="small-flag">
        </a>
        <a href="?lang=de" style="text-decoration: none">
            <img src="https://flagicons.lipis.dev/flags/4x3/de.svg"
                 alt="German Flag"
                 class="small-flag">
        </a>
        <a href="?lang=cs" style="text-decoration: none">
            <img src="https://flagicons.lipis.dev/flags/4x3/cz.svg"
                 alt="Czech Flag"
                 class="small-flag">
        </a>
    </form>
</div>