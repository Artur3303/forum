<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login - Forum</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center align-items-center h-75">
        <div class="col-md-4">
            <form action="/login" method="post">
                <fieldset>
                    <legend>Log in</legend>
                    <#if RequestParameters.error??>
                        <div class="alert alert-warning">Invalid username or password.</div>
                    </#if>
                    <#if RequestParameters.logout??>
                        <div class="alert alert-success">You have been logged out.</div>
                    </#if>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <div class="form-group">
                        <label for="username" class="col-form-label-sm">Username</label>
                        <#if RequestParameters.error??>
                            <input type="text" id="username" name="username" class="form-control border-warning">
                        <#else>
                            <input type="text" id="username" name="username" class="form-control">
                        </#if>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-form-label-sm">Password</label>
                        <#if RequestParameters.error??>
                            <input type="password" id="password" name="password" class="form-control border-warning">
                        <#else>
                            <input type="password" id="password" name="password" class="form-control">
                        </#if>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Log in</button>
                        <a href="/signup" class="btn-sm float-right">Sign up here</a>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<script src="/resources/js/jquery-3.4.1.min.js"></script>
<script src="/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>