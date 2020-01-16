<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forum</title>
</head>
<body>
<ul class="forum-topics">
    <#list topics as topic>
        <li class="topic_name">${topic.getName()}</li>
    </#list>
</ul>
</body>
</html>