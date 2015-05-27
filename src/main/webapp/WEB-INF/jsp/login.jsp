<html>
<head>
    <title>Messages : Login</title>
</head>
<body>
<div id="content">
    <form name="f" action="/login/openid" method="post" id="openid_form">
        <input type="hidden" name="action" value="verify"/>
        <fieldset>
            <legend>Sign-in</legend>

            <div id="openid_input_area">
                Select your OpenID provider : <input id="openid_identifier" name="openid_identifier" type="text" value="https://www.appdirect.com/openid/id" size="50"/>
                <input id="openid_submit" type="submit" value="Sign-In"/>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
