<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up - Forum</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/signup.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center align-items-center h-75">
        <div class="col-md-5">
            <form action="/signup" method="post">
                <fieldset>
                    <legend>Sign up</legend>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <div class="form-group">
                        <label for="username" class="col-form-label-sm">Username</label>
                        <input type="text" id="username" name="username" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="first-name" class="col-form-label-sm">First name</label>
                        <input type="text" id="first-name" name="firstName" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="last-name" class="col-form-label-sm">Last name</label>
                        <input type="text" id="last-name" name="lastName" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-form-label-sm">Password</label>
                        <input type="password" id="password" name="password" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="matching-password" class="col-form-label-sm">Confirm password</label>
                        <input type="password" id="matching-password" name="matchingPassword" class="form-control">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Sign up</button>
                        <a href="/login" class="btn-sm float-right">Log in here</a>
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