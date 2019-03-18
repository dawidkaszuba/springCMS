<nav class="navbar navbar-dark bg-secondary navbar-expand-md">
    <style>
        .nav-item:hover, .navbar-toggler-icon, .dropdown-item:hover {
            background-color: lightgrey;
        }

    </style>


    <button class="navbar navbar-toggler" type="button" data-toggle="collapse" data-target="#mainMenu"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="mainMenu">

        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link text-dark active" href="/">Dash</a></li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">articles</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">add article</a>
                    <a class="dropdown-item" href="/articles/list">all articles</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">categories</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/categories/add">add category</a>
                    <a class="dropdown-item" href="/categories/list">all categories</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">authors</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">add author</a>
                    <a class="dropdown-item" href="#">all authors</a>
                </div>
            </li>

        </ul>

    </div>

</nav>