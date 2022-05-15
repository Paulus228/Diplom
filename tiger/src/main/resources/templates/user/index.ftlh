<#import "../patterns/common.ftlh" as common>
<#include "../patterns/creaditionals.ftlh"/>

<@common.page>

    <!-- Page Content -->
    <!-- Banner Starts Here -->
    <div class="banner header-text">
        <div class="owl-banner owl-carousel">
            <div class="banner-item-01">
                <div class="text-content">
                    <h4>Find your car today!</h4>
                    <h2>Lorem ipsum dolor sit amet</h2>
                </div>
            </div>
            <div class="banner-item-02">
                <div class="text-content">
                    <h4>Fugiat Aspernatur</h4>
                    <h2>Laboriosam reprehenderit ducimus</h2>
                </div>
            </div>
            <div class="banner-item-03">
                <div class="text-content">
                    <h4>Saepe Omnis</h4>
                    <h2>Quaerat suscipit unde minus dicta</h2>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner Ends Here -->

    <div class="latest-products">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-heading">
                        <h2>Featured Cars</h2>
                        <#if carlist?size gt 0>
                            <a href="/cars/all">view more <i class="fa fa-angle-right"></i></a>
                        </#if>
                    </div>
                </div>
                <#if carlist?size gt 0>
                    <#list carlist as car>
                        <div class="col-lg-4 col-md-6">
                            <div class="product-item">
                                <a href="/cars/${car.id}">
                                    <#if carphotoservice.findallByidCar(car.id)?size gt 0>
                                        <img src="${carphotoservice.findallByidCar(car.id)[0].photourl}"
                                             alt="${car.name}">
                                    <#else>
                                        <img src="/static/users/img/product-1-370x270.jpg" alt="${car.name}">
                                    </#if>
                                </a>
                                <div class="down-content">
                                    <a href="/cars/${car.id}"><h4>${car.name}
                                            - <#if carinfoservice.getonecarinfobycarid(car.id)??></#if></h4></a>

                                    <h6><small>
                                            <del> $${car.price}</del>
                                        </small> $${car.price-120}</h6>

                                    <#if carinfoservice.getonecarinfobycarid(car.id)??>
                                    <p>${carinfoservice.getonecarinfobycarid(car.id).power} hp
                                        &nbsp;/&nbsp; ${carinfoservice.getonecarinfobycarid(car.id).fuel}
                                        &nbsp;/&nbsp; ${carinfoservice.getonecarinfobycarid(car.id).first_reg} &nbsp;/&nbsp; ${carinfoservice.getonecarinfobycarid(car.id).model}</p>

                                    <small>
                                        <strong title="Author"><i
                                                    class="fa fa-dashboard"></i> ${carinfoservice.getonecarinfobycarid(car.id).mileage}
                                            km</strong> &nbsp;&nbsp;&nbsp;&nbsp;
                                        <strong title="Author"><i
                                                    class="fa fa-cube"></i> ${carinfoservice.getonecarinfobycarid(car.id).enginesize}
                                            cc</strong>&nbsp;&nbsp;&nbsp;&nbsp;
                                        <strong title="Views"><i
                                                    class="fa fa-cog"></i> ${carinfoservice.getonecarinfobycarid(car.id).gearbox}
                                        </strong>
                                    </small>

                                    </#if>
                                    <#if user??>
                                        <a class="btn btn-dark" href="/basket/add/${car.id}/${currentUserId}">Add</a>
                                    </#if>
                                </div>
                            </div>
                        </div>
                    </#list>
                <#else>
                    <div class="col-lg-4 col-md-6">
                        <p>All car has saled!</p>
                    </div>
                </#if>
            </div>
        </div>
    </div>

    <div class="best-features">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-heading">
                        <h2>About Us</h2>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="left-content">
                        <p>Lorem ipsum dolor sit amet, <a href="#">consectetur</a> adipisicing elit. Explicabo, esse
                            consequatur alias repellat in excepturi inventore ad <a href="#">asperiores</a> tempora
                            ipsa. Accusantium tenetur voluptate labore aperiam molestiae rerum excepturi minus in
                            pariatur praesentium, corporis, aliquid dicta.</p>
                        <ul class="featured-list">
                            <li><a href="#">Lorem ipsum dolor sit amet</a></li>
                            <li><a href="#">Consectetur an adipisicing elit</a></li>
                            <li><a href="#">It aquecorporis nulla aspernatur</a></li>
                            <li><a href="#">Corporis, omnis doloremque</a></li>
                        </ul>
                        <a href="/aboutus" class="filled-button">Read More</a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="right-image">
                        <img src="/static/users/img/about-1-570x350.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="services" style="background-image: url(/static/users/img/other-image-fullscren-1-1920x900.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-heading">
                        <h2>Latest blog posts</h2>

                        <a href="blog.html">read more <i class="fa fa-angle-right"></i></a>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6">
                    <div class="service-item">
                        <a href="#" class="services-item-image"><img src="/static/users/img/blog-1-370x270.jpg"
                                                                     class="img-fluid" alt=""></a>

                        <div class="down-content">
                            <h4><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit hic</a></h4>

                            <p style="margin: 0;"> John Doe &nbsp;&nbsp;|&nbsp;&nbsp; 12/06/2020 10:30 &nbsp;&nbsp;|&nbsp;&nbsp;
                                114</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="service-item">
                        <a href="#" class="services-item-image"><img src="/static/users/img/blog-2-370x270.jpg"
                                                                     class="img-fluid" alt=""></a>

                        <div class="down-content">
                            <h4><a href="#">Lorem ipsum dolor sit amet consectetur adipisicing elit</a></h4>

                            <p style="margin: 0;"> John Doe &nbsp;&nbsp;|&nbsp;&nbsp; 12/06/2020 10:30 &nbsp;&nbsp;|&nbsp;&nbsp;
                                114</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="service-item">
                        <a href="#" class="services-item-image"><img src="/static/users/img/blog-3-370x270.jpg"
                                                                     class="img-fluid" alt=""></a>

                        <div class="down-content">
                            <h4><a href="#">Aperiam modi voluptatum fuga officiis cumque</a></h4>

                            <p style="margin: 0;"> John Doe &nbsp;&nbsp;|&nbsp;&nbsp; 12/06/2020 10:30 &nbsp;&nbsp;|&nbsp;&nbsp;
                                114</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="happy-clients">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-heading">
                        <h2>Happy Clients</h2>
                        <#if testimonals?size gt 0>
                            <a href="/testimonals">read more <i class="fa fa-angle-right"></i></a>
                        </#if>
                    </div>
                </div>
                <#if testimonals?size gt 0>
                    <div class="col-md-12">
                        <div class="owl-clients owl-carousel text-center">
                            <#list testimonals as testi>
                                <div class="service-item">
                                    <div class="icon">
                                        <i class="fa fa-user"></i>
                                    </div>
                                    <div class="down-content">
                                        <h4>${testi.fullname}</h4>
                                        <p class="n-m"><em>"${testi.message_testimonals}"</em></p>
                                    </div>
                                </div>
                            </#list>
                        </div>
                    </div>
                <#else>
                    <p style="text-align: center">Testimonals no has yet!</p>
                </#if>
            </div>
        </div>
    </div>


    <div class="call-to-action">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="inner-content">
                        <div class="row">
                            <div class="col-md-8">
                                <h4>Lorem ipsum dolor sit amet, consectetur adipisicing.</h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque corporis amet elite
                                    author nulla.</p>
                            </div>
                            <div class="col-lg-4 col-md-6 text-right">
                                <a href="/contact/" class="filled-button">Contact Us</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@common.page>