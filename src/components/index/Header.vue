<template>
    <header class="header">
        <nav class="navbar">
            <!-- Search Box-->
            <div class="search-box">
                <button class="dismiss"><i class="icon-close"></i></button>
                <form action="#" id="searchForm" role="search">
                    <input class="form-control" placeholder="What are you looking for..." type="search">
                </form>
            </div>
            <div class="container-fluid">
                <div class="navbar-holder d-flex align-items-center justify-content-between">
                    <!-- Navbar Header-->
                    <div class="navbar-header">
                        <!-- Navbar Brand -->
                        <a class="navbar-brand d-none d-sm-inline-block" href="index.html">
                        <div class="brand-text d-none d-lg-inline-block">
                            <span>软件缺陷管理系统</span></div>
                        <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>软件缺陷管理系统</strong></div>
                    </a>
                        <!-- Toggle Button-->
                        <a class="menu-btn active" id="toggle-btn"><span></span><span></span><span></span></a>
                    </div>
                    <!-- Navbar Menu -->
                    <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                        <!--&lt;!&ndash; Search&ndash;&gt;-->
                        <!--<li class="nav-item d-flex align-items-center"><a href="#" id="search"><i-->
                            <!--class="icon-search"></i></a></li>-->
                        <!--&lt;!&ndash; Notifications&ndash;&gt;-->
                        <!--<li class="nav-item dropdown">-->
                            <!--<a aria-expanded="false" aria-haspopup="true" class="nav-link"-->
                               <!--data-target="#" data-toggle="dropdown" href="#" id="notifications" rel="nofollow">-->
                                <!--<i class="fa fa-bell-o"></i>-->
                                <!--<span class="badge bg-red badge-corner">12</span>-->
                            <!--</a>-->
                            <!--<ul aria-labelledby="notifications" class="dropdown-menu">-->
                                <!--<li><a class="dropdown-item" href="#" rel="nofollow">-->
                                    <!--<div class="notification">-->
                                        <!--<div class="notification-content"><i class="fa fa-envelope bg-green"></i>You-->
                                            <!--have 6 new messages-->
                                        <!--</div>-->
                                        <!--<div class="notification-time">-->
                                            <!--<small>4 minutes ago</small>-->
                                        <!--</div>-->
                                    <!--</div>-->
                                <!--</a></li>-->
                                <!--<li><a class="dropdown-item" href="#" rel="nofollow">-->
                                    <!--<div class="notification">-->
                                        <!--<div class="notification-content">-->
                                            <!--<i class="fa fa-twitter bg-blue"></i>-->
                                            <!--You have 2 followers-->
                                        <!--</div>-->
                                        <!--<div class="notification-time">-->
                                            <!--<small>4 minutes ago</small>-->
                                        <!--</div>-->
                                    <!--</div>-->
                                <!--</a></li>-->
                                <!--<li><a class="dropdown-item" href="#" rel="nofollow">-->
                                    <!--<div class="notification">-->
                                        <!--<div class="notification-content">-->
                                            <!--<i class="fa fa-upload bg-orange"></i>-->
                                            <!--Server Rebooted-->
                                        <!--</div>-->
                                        <!--<div class="notification-time">-->
                                            <!--<small>4 minutes ago</small>-->
                                        <!--</div>-->
                                    <!--</div>-->
                                <!--</a></li>-->
                                <!--<li><a class="dropdown-item" href="#" rel="nofollow">-->
                                    <!--<div class="notification">-->
                                        <!--<div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have-->
                                            <!--2 followers-->
                                        <!--</div>-->
                                        <!--<div class="notification-time">-->
                                            <!--<small>10 minutes ago</small>-->
                                        <!--</div>-->
                                    <!--</div>-->
                                <!--</a></li>-->
                                <!--<li><a class="dropdown-item all-notifications text-center" href="#" rel="nofollow">-->
                                    <!--<strong>view all notifications </strong></a></li>-->
                            <!--</ul>-->
                        <!--</li>-->
                        <!--&lt;!&ndash; Messages                        &ndash;&gt;-->
                        <!--<li class="nav-item dropdown"><a aria-expanded="false" aria-haspopup="true" class="nav-link"-->
                                                         <!--data-target="#"-->
                                                         <!--data-toggle="dropdown" href="#"-->
                                                         <!--id="messages" rel="nofollow"><i-->
                            <!--class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>-->
                            <!--<ul aria-labelledby="notifications" class="dropdown-menu">-->
                                <!--<li><a class="dropdown-item d-flex" href="#" rel="nofollow">-->
                                    <!--<div class="msg-profile"><img alt="..." class="img-fluid rounded-circle"-->
                                                                  <!--src="../../../static/template/img/avatar-1.jpg"></div>-->
                                    <!--<div class="msg-body">-->
                                        <!--<h3 class="h5">Jason Doe</h3><span>Sent You Message</span>-->
                                    <!--</div>-->
                                <!--</a></li>-->
                                <!--<li><a class="dropdown-item d-flex" href="#" rel="nofollow">-->
                                    <!--<div class="msg-profile"><img alt="..." class="img-fluid rounded-circle"-->
                                                                  <!--src="../../../static/template/img/avatar-2.jpg"></div>-->
                                    <!--<div class="msg-body">-->
                                        <!--<h3 class="h5">Frank Williams</h3><span>Sent You Message</span>-->
                                    <!--</div>-->
                                <!--</a></li>-->
                                <!--<li><a class="dropdown-item d-flex" href="#" rel="nofollow">-->
                                    <!--<div class="msg-profile"><img alt="..." class="img-fluid rounded-circle"-->
                                                                  <!--src="../../../static/template/img/avatar-3.jpg"></div>-->
                                    <!--<div class="msg-body">-->
                                        <!--<h3 class="h5">Ashley Wood</h3><span>Sent You Message</span>-->
                                    <!--</div>-->
                                <!--</a></li>-->
                                <!--<li><a class="dropdown-item all-notifications text-center" href="#" rel="nofollow">-->
                                    <!--<strong>Read all messages </strong></a></li>-->
                            <!--</ul>-->
                        <!--</li>-->
                        <!--&lt;!&ndash; Languages dropdown    &ndash;&gt;-->
                        <!--<li class="nav-item dropdown">-->
                            <!--<a aria-expanded="false" aria-haspopup="true"-->
                               <!--class="nav-link language dropdown-toggle" data-target="#"-->
                               <!--data-toggle="dropdown" href="#"-->
                               <!--id="languages"-->
                               <!--rel="nofollow">-->
                                <!--<img alt="English" src="../../../static/template/img/flags/16/GB.png"><span-->
                                <!--class="d-none d-sm-inline-block">English</span></a>-->
                            <!--<ul aria-labelledby="languages" class="dropdown-menu">-->
                                <!--<li><a class="dropdown-item" href="#" rel="nofollow">-->
                                    <!--<img alt="English" class="mr-2" src="../../../static/template/img/flags/16/DE.png">German</a>-->
                                <!--</li>-->
                                <!--<li><a class="dropdown-item" href="#" rel="nofollow"> <img-->
                                    <!--alt="English" class="mr-2" src="../../../static/template/img/flags/16/FR.png">French-->
                                <!--</a></li>-->
                            <!--</ul>-->
                        <!--</li>-->
                        <!-- Logout    -->
                        <li class="nav-item">
                            <router-link :to="{path: '/auth/login'}" class="nav-link logout">
                                <span class="d-none d-sm-inline">退出登录</span>
                                <i class="fa fa-sign-out"></i>
                            </router-link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
</template>

<script>
    export default {
        name: 'Header'
    }
</script>

<style scoped>

</style>
