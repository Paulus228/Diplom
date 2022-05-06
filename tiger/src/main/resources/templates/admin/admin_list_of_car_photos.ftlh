<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <meta name="author" content="AdminKit">
    <meta name="keywords"
          content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="shortcut icon" href="/static/admin/img/icons/Daco_47612.png"/>

    <title>Car dealer tiger - Admin panel</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap" rel="stylesheet">
    <link href="/static/admin/css/app.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&family=Quicksand:wght@300&display=swap');

        body {
            font-family: 'Quicksand', sans-serif
        }

        #gallery #gallery-container {
            position: relative;
            width: 100%;
            height: 0px;
            padding-bottom: 56.7%; /* 16/9 ratio */
            background-color: transparent;
        }

        #gallery #gallery-container #gallery-content {
            position: absolute;
            top: 0px;
            right: 0px;
            bottom: 0px;
            left: 0px;
            height: 100%;
            display: flex;

            scroll-snap-type: x mandatory;
            overflow-x: scroll;
            scroll-behavior: smooth;
        }

        #gallery #gallery-container #gallery-content .gallery__item {
            width: 100%;
            height: 100%;
            flex-shrink: 0;
            scroll-snap-align: start;
            scroll-snap-stop: always;
            position: relative;
        }

        #gallery #gallery-container #gallery-content .gallery__item img {
            display: block;
            width: 100%;
            height: 100%;
            object-fit: contain;
            background-color: white;
        }

        .click-zone {
            position: absolute;
            width: 20%;
            height: 100%;
            z-index: 3;
        }

        .click-zone.click-zone-prev {
            left: 0px;
        }

        .click-zone.click-zone-next {
            right: 0px;
        }

        #gallery:not(:hover) .arrow {
            opacity: 0;
        }

        .arrow {
            text-align: center;
            z-index: 3;
            position: absolute;
            display: block;
            width: 25px;
            height: 25px;
            background-color: white;
            border-radius: 50%;
            text-decoration: none;
            color: black;
            opacity: 0.5;
            transition: opacity 200ms ease;
        }

        .arrow:hover {
            opacity: .8;
        }

        .arrow span {
            position: relative;
            top: 2px;
        }

        .arrow.arrow-prev {
            top: 50%;
            left: 5px;
        }

        .arrow.arrow-next {
            top: 50%;
            right: 5px;
        }

        .arrow.arrow-disabled {
            opacity: 0.1;
        }

        #gallery:not(:hover) #gallery-controls {
            opacity: 0;
        }

        #gallery #gallery-container #gallery-controls {
            display: flex;
            width: 100%;
            justify-content: center;
            z-index: 4;
            position: absolute;
            right: 0;
            bottom: 1em;
            left: 0;
            text-align: center;
        }

        #gallery #gallery-container #gallery-controls .controls__dot {
            width: 0.85em;
            height: 0.85em;
            border-radius: 50%;
            outline: none;
            background-color: #fff;
            opacity: .3;
            cursor: pointer;
            transition: opacity 200ms ease;
        }

        .controls__dot:not(:first-child) {
            margin-left: 0.25em;
        }

        #gallery #gallery-container #gallery-controls .controls__dot:hover {
            opacity: .8;
        }


        #gallery:not(:hover) #gallery-container #toggleFullscreenVisual {
            opacity: 0;
        }

        #gallery #gallery-container #toggleFullscreenVisual {
            display: block;
            width: 40px;
            height: 40px;
            position: absolute;
            top: 10px;
            right: 10px;

            cursor: pointer;
            z-index: 4;
            background-color: white;
            opacity: .3;
            transition: opacity 200ms ease;
        }

        #gallery #gallery-container #toggleFullscreenVisual:hover {
            opacity: .8;
        }

        #toggleFullscreen {
            display: none;
        }

        #toggleFullscreen:checked ~ main {
            height: 100vh;
            overflow: hidden;
        }

        #toggleFullscreen:checked ~ main #gallery #gallery-container {
            position: absolute;
            top: 0px;
            right: 0px;
            bottom: 0px;
            left: 0px;
            height: 100%;
            padding-bottom: 0px;
        }

        #toggleFullscreen:checked ~ main #gallery #toggleFullscreenVisual {
            opacity: .6;
            background-color: grey;
            position: fixed;
        }

        #toggleFullscreen:checked ~ main #gallery #gallery-controls {
            position: fixed;
        }

        #toggleFullscreen:checked ~ main #gallery #gallery-controls .controls__dot {
            opacity: .6;
            background-color: grey;
        }


        main #content {
            padding: 0px 36px;
        }

        main #content p {
            margin-top: 36px;
        }

    </style>
</head>

<body>

<#if message_save_car??>
    <script>
        alert("Car add success!")
    </script>
</#if>

<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="/admin/">
                <span class="align-middle" style="font-size: 15px;font-weight: 400">
                <span class="align-middle" style="font-size: 15px;font-weight: 400"><img src="/static/admin/img/icons/Daco_47612.png" width="50" height="50"/> Car Dealer Tiger<br/> Admin panel</span>
            </a>
            <ul class="sidebar-nav">
                <li class="sidebar-header">
                    Administration
                </li>

                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/">
                        <i class="align-middle" data-feather="sliders"></i> <span class="align-middle">Dashboard</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/help">
                        <i class="align-middle" data-feather="help-circle"></i> <span
                                class="align-middle">Help center</span>
                    </a>
                </li>
                <li class="sidebar-header">
                    Lists
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="/admin/carlist">
                        <i class="align-middle" data-feather="book"></i> <span class="align-middle">List of car</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/userlist/">
                        <i class="align-middle" data-feather="book"></i> <span class="align-middle">List of user</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/contactlist/">
                        <i class="align-middle" data-feather="book"></i> <span
                                class="align-middle">List of contacts</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/orderlist/">
                        <i class="align-middle" data-feather="book"></i> <span class="align-middle">List of order</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/testimonalslist/">
                        <i class="align-middle" data-feather="book"></i> <span
                                class="align-middle">List of testimonals</span>
                    </a>
                </li>
            </ul>

        </div>
    </nav>

    <div class="main">
        <nav class="navbar navbar-expand navbar-light navbar-bg">
            <a class="sidebar-toggle js-sidebar-toggle">
                <i class="hamburger align-self-center"></i>
            </a>

            <div class="navbar-collapse collapse">
                <ul class="navbar-nav navbar-align">
                    <li class="nav-item dropdown">
                        <a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-bs-toggle="dropdown">
                            <i class="align-middle" data-feather="settings"></i>
                        </a>

                        <a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
                            <i data-feather="settings"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end">
                            <a class="dropdown-item" href="/admin/"><i class="align-middle me-1"
                                                                       data-feather="pie-chart"></i> Analytics</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/cardealertiger/"><i class="align-middle me-1"
                                                                                data-feather="settings"></i> Settings &
                                Privacy</a>
                            <a class="dropdown-item" href="/admin/help"><i class="align-middle me-1"
                                                                           data-feather="help-circle"></i> Help
                                Center</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Log out</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="content">
            <div class="container-fluid p-0">

                <h1 class="h3 mb-3"><strong>Car photo</strong> List</h1>
                <a class="btn btn-info" href="/admin/carlist/carphotos/add/${carid}" style="margin-bottom: 15px"><i
                            data-feather="plus-circle"></i>Add new photo</a>
                <div class="row">
                    <div class="col-12 col-lg-8 col-xxl-9 d-flex" style="margin: 0 auto">
                        <div class="card flex-fill">
                            <div class="card-header">
                                <h5 class="card-title mb-0">List of car photos</h5>
                            </div>
                            <div id="gallery">
                                <div id="gallery-container">
                                    <div id="gallery-content">
                                        <#if carphotolist?size!=0>
                                            <#list carphotolist as carphoto>
                                                <div id="#pic_${carphoto?index-1}" class="gallery__item">
                                                    <a href="#" class="click-zone cl-1ck-zone-prev">
                                                        <div class="arrow arrow-disabled arrow-prev"><span>&lt;</span>
                                                        </div>
                                                    </a>
                                                    <a href="#pic_${carphoto?index+1}"
                                                       class="click-zone click-zone-next">
                                                        <div class="arrow arrow-next"><span>&gt;</span></div>
                                                    </a>
                                                    <img src="${carphoto.photourl}" alt="TODO">
                                                </div>
                                            </#list>
                                        <#else>
                                            <tr>
                                                <td>No one car photo yet!</td>
                                            </tr>
                                        </#if>

                                    </div>

                                </div>
                            </div>
                            <div class="table-responsive" style="margin-top: 30px">
                                <table class="table table-hover my-0">
                                    <thead>
                                    <tr>
                                        <th>Photo url</th>
                                        <th>Remove</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#if carphotolist?size!=0>
                                        <#list carphotolist as carphoto>
                                            <tr>
                                                <td>${carphoto.photourl}</td>
                                                <td><a href="/admin/carlist/carphotos/remove/${carphoto.id}/${carphoto.id_car}" style="width: 98px;" class="btn btn-danger"><span data-feather="trash-2"></span>Remove</a></td>

                                            </tr>
                                        </#list>
                                    <#else>
                                        <tr>
                                            <td>No one car photo yet!</td>
                                        </tr>
                                    </#if>
                                    </tbody>
                                </table>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>

    <script src="../../js/app.js"></script>


</body>

</html>