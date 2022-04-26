<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <meta name="author" content="AdminKit">
    <meta name="keywords" content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="shortcut icon" href="../../img/icons/Daco_47612.png"/>

    <title>Car dealer tiger - Admin panel</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap" rel="stylesheet">
    <link href="../../css/app.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&family=Quicksand:wght@300&display=swap');
        body{
            font-family: 'Quicksand', sans-serif }
    </style>
</head>

<body>

<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="/admin/">
                <span class="align-middle" style="font-size: 15px;font-weight: 400"><img src="../../img/icons/Daco_47612.png" width="50" height="50"/> Car Dealer Tiger<br/> Admin panel</span>
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
                        <i class="align-middle" data-feather="help-circle"></i> <span class="align-middle">Help center</span>
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
                <li class="sidebar-item ">
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

                <h1 class="h3 mb-3"><strong>Extract</strong> List</h1>
                <a class="btn btn-info" href="/admin/carlist/extracts/add/${carid}" style="margin-bottom: 15px"><i data-feather="plus-circle"></i>Add new</a>
                <div class="row">
                    <div class="col-12 col-lg-8 col-xxl-9 d-flex" style="margin: 0 auto">
                        <div class="card flex-fill">
                            <div class="card-header">

                                <h5 class="card-title mb-0">List of extract for car</h5>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-hover my-0">
                                    <thead>
                                    <tr>
                                        <th>Car name</th>
                                        <th>Extract</th>
                                        <th class="d-none d-xl-table-cell">Remove</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#if carextractlist?size!=0>
                                        <#list carextractlist as extract>
                                            <tr>
                                                <td>${carservice.getonecar(extract.id_car).name}</td>
                                                <td>${extract.extract}</td>
                                                <td><a href="/admin/contactlist/remove/${extract.id}" style="width: 98px;" class="btn btn-danger"><span data-feather="trash-2"></span>Remove</a></td>
                                            </tr>
                                        </#list>
                                    <#else>
                                        <tr>
                                            <td>No one extracts yet!</td>
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
</div>

<script src="../../js/app.js"></script>

</body>

</html>