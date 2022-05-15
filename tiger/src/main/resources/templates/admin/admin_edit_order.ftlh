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
    </style>
</head>

<body>

<#if message_edit_car??>
    <script>
        alert("Error in edit car! Try yet!")
    </script>
</#if>
<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="/admin/">
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
                        <i class="align-middle" data-feather="help-circle"></i> <span class="align-middle">Help center</span>
                    </a>
                </li>
                <li class="sidebar-header">
                    Lists
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="/admin/carlist">
                        <i class="align-middle" data-feather="list"></i> <span class="align-middle">List of car</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/userlist/">
                        <i class="align-middle" data-feather="list"></i> <span class="align-middle">List of user</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/contactlist/">
                        <i class="align-middle" data-feather="list"></i> <span
                                class="align-middle">List of contacts</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/orderlist/">
                        <i class="align-middle" data-feather="list"></i> <span class="align-middle">List of order</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="/admin/testimonalslist/">
                        <i class="align-middle" data-feather="list"></i> <span
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
                <div class="row vh-80">
                    <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
                        <div class="d-table-cell align-middle">
                            <div class="text-center mt-4">
                                <h1 class="h2">Edit order with id - ${orderupdate.id}</h1>
                                <p class="lead">
                                    Start creating the best possible user experience for you customers.
                                </p>
                            </div>

                            <div class="card">
                                <div class="card-body">
                                    <div class="m-sm-4">
                                        <form method="post" action="/admin/orderlist/update/${orderupdate.id}">
                                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                            <div class="mb-3">
                                                <label class="form-label">Country</label>
                                                <input   required="required" maxlength="255" minlength="5" class="form-control form-control-lg" type="text" name="country"
                                                       placeholder="Enter name car" value="${orderupdate.country}"/>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">City</label>
                                                <input   required="required" maxlength="255" minlength="5" class="form-control form-control-lg" type="text" name="city"
                                                       placeholder="Enter name car" value="${orderupdate.city}"/>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">City</label>
                                                <input   required="required" maxlength="255" minlength="5" class="form-control form-control-lg" type="text" name="address"
                                                       placeholder="Enter name car" value="${orderupdate.address}"/>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">City</label>
                                                <input   required="required" maxlength="255" minlength="5" class="form-control form-control-lg" type="text" name="contactphone"
                                                       placeholder="Enter name car" value="${orderupdate.contactphone}"/>
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Order status:</label>
                                                <select name="order_status" class="form-select" aria-label="Default select example" required="required">
                                                    <option <#if orderupdate.status_order=="PROCEED">selected</#if> value="PROCEED">Proceed</option>
                                                    <option <#if orderupdate.status_order=="ARRIVED">selected</#if> value="ARRIVED">Arrived</option>
                                                    <option <#if orderupdate.status_order=="SALES">selected</#if> value="SALES">Sales</option>
                                                </select>
                                            </div>

                                            <div class="text-center mt-3">
                                                <button type="submit" class="btn btn-lg btn-primary">Update</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<script src="../js/app.js"></script>

</body>

</html>