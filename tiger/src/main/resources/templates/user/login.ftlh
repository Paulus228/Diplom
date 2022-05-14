<#import "../patterns/common.ftlh" as common>

<@common.page>
    <script>
        <#if message??>
            alert("Success sign up! Welcome!");
        </#if>
    </script>
    <main class="d-flex w-100" >
        <div class="container d-flex flex-column" style="margin-top: 100px">
            <div class="row vh-100">
                <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
                    <div class="d-table-cell align-middle">

                        <div class="text-center mt-4">
                            <h3>Welcome back, glad to see you!</h3>
                            <p class="lead">
                                Sign in to your account to continue
                            </p>
                        </div>

                        <div class="card">
                            <div class="card-body">
                                <div class="m-sm-4">
                                    <div class="text-center">
                                        <img src="/static/users/img/Daco_47612.png" alt="Charles Hall" class="img-fluid rounded-circle" width="132" height="132" />
                                    </div>
                                    <form method="post" action="/login">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <div class="mb-3">
                                            <label class="form-label">Username:</label>
                                            <input class="form-control" type="text" name="username" placeholder="Enter your username" required="required"/>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Password:</label>
                                            <input class="form-control" type="password" name="password" placeholder="Enter your password" required="required"/>
                                        </div>
                                        <div>
                                            <label class="form-check">
                                               <a href="/signup/">No account? Create now!</a>
                                            </label>
                                        </div>
                                        <div class="text-center mt-3">
                                              <button type="submit" class="btn btn-dark">Sign in</button>
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