<!-- Header -->
<#include "creaditionals.ftlh"/>
<header class="">
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="index.html"><h2><img width="50" height="50"
                                                               src="/static/users/img/Daco_47612.png"/> Car Dealer <em>Tiger</em>
                </h2></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Home
                        </a>
                    </li>

                    <li class="nav-item"><a class="nav-link" href="/cars/all">Cars</a></li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true" aria-expanded="false">More</a>

                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="blog.html">Blog</a>
                            <a class="dropdown-item" href="/team">Team</a>
                            <a class="dropdown-item" href="/testimonals/">Testimonials</a>
                            <a class="dropdown-item" href="/terms">Terms</a>
                        </div>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="/aboutus">About Us</a></li>
                    <li class="nav-item"><a class="nav-link" href="/contact/">Contact Us</a></li>
                    <#if user??>
                        <li class="nav-item"><a class="nav-link" href="/basket/${currentUserId}">Basket</a></li>
                    </#if>
                    <li class="nav-item">
                        <#if user??>
                            <form action="/logout" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button type="submit" class="nav-link">Logout</button>
                            </form>
                        <#else>
                            <a href="/login" class="nav-link">Login</a>
                        </#if>
                    </li>
                    <#if isAdmin>
                        <li class="nav-item">
                            <a class="nav-link">Administation</a>
                        </li>
                    </#if>

                </ul>
            </div>
        </div>
    </nav>
</header>