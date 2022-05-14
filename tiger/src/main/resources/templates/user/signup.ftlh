<#import "../patterns/common.ftlh" as common>

<@common.page>
    <script>
        <#if message??>
        alert("User with username or email exists! Try yet!")
        </#if>
    </script>
    <main class="d-flex w-100">
        <div class="container d-flex flex-column" style="margin-top: 100px">
            <div class="row vh-100">
                <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
                    <div class="d-table-cell align-middle">

                        <div class="text-center mt-4">
                            <h1 class="h2">Get started</h1>
                            <p class="lead">
                                Work with us. We want to make you happy!
                            </p>
                        </div>

                        <div class="card">
                            <div class="card-body">
                                <div class="m-sm-4">
                                    <form action="/signup/save" method="post">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <div class="mb-3">
                                            <label class="form-label">Name</label>
                                            <input class="form-control" type="text" minlength="5" maxlength="100"
                                                   required="required" name="name" placeholder="Enter your name"/>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Soname</label>
                                            <input class="form-control" type="text" minlength="5" maxlength="100"
                                                   required="required" name="soname" placeholder="Enter your soname"/>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Username</label>
                                            <input class="form-control" type="text" minlength="5" maxlength="80"
                                                   required="required" name="username" placeholder="Enter your name"/>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Email</label>
                                            <input class="form-control" type="email" name="email" required="required"
                                                   placeholder="Enter your email"/>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Password</label>
                                            <input pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" class="form-control"
                                                   type="password" name="password" minlength="8" maxlength="40"
                                                   required="required" placeholder="Enter password"/>
                                            <small>Minimum eight characters, at least one letter and one number</small>
                                        </div>
                                        <div class="text-center mt-3">
                                            <button type="submit" class="btn btn-primary">Sign up</button>
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

</@common.page>