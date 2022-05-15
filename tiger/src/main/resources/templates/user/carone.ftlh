<#import "../patterns/common.ftlh" as common>
<#include "../patterns/creaditionals.ftlh"/>

<@common.page>
    <!-- Page Content -->
    <div class="page-heading about-heading header-text"
         style="background-image: url(/static/users/img/heading-6-1920x500.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="text-content">
                        <h4>
                            <del>$${car.price}</del>
                            <strong class="text-primary">$${car.price-120}</strong></h4>
                        <h2>${car.name}</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="products">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <#if carphotoservice.findallByidCar(car.id)?size gt 0>
                            <img class="img-fluid wc-image" src="${carphotoservice.findallByidCar(car.id)[0].photourl}"
                                 alt="${car.name}">
                        <#else>
                            <img class="img-fluid wc-image" src="/static/users/img/product-1-370x270.jpg" alt="${car.name}">
                        </#if>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-4 col-6">
                            <div>
                                <#if carphotoservice.findallByidCar(car.id)?size gt 0>
                                    <#list carphotoservice.findallByidCar(car.id) as photo>
                                        <img src="${photo.photourl}"
                                             alt="${car.name}" class="img-fluid">
                                    </#list>
                                <#else>
                                    <img src="/static/users/img/product-1-370x270.jpg" alt="${car.name}" class="img-fluid">
                                </#if>
                            </div>
                            <br>
                        </div>

                    </div>
                </div>

                <div class="col-md-6">
                    <a class="btn btn-dark" style="float: right" href="/basket/add/${car.id}/${currentUserId}">Buy</a>
                    <form action="#" method="post" class="form">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Type</span>

                                    <#if carinfoservice.getonecarinfobycarid(car.id)??><strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).type}</strong></#if>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Make</span>

                                    <#if carinfoservice.getonecarinfobycarid(car.id)??> <strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).make}</strong></#if>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left"> Model</span>

                                    <#if carinfoservice.getonecarinfobycarid(car.id)??> <strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).model}</strong></#if>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">First registration</span>

                                     <#if carinfoservice.getonecarinfobycarid(car.id)??><strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).first_reg}</strong></#if>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Mileage</span>

                                     <#if carinfoservice.getonecarinfobycarid(car.id)??><strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).mileage}</#if>
                                        km</strong>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Fuel</span>

                                     <#if carinfoservice.getonecarinfobycarid(car.id)??><strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).fuel}</strong></#if>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Engine size</span>

                                     <#if carinfoservice.getonecarinfobycarid(car.id)??><strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).enginesize}</#if>
                                        cc</strong>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Power</span>

                                     <#if carinfoservice.getonecarinfobycarid(car.id)??><strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).power}</#if>
                                        hp</strong>
                                </div>
                            </li>


                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Gearbox</span>

                                     <#if carinfoservice.getonecarinfobycarid(car.id)??><strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).gearbox}</strong></#if>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Number of seats</span>

                                    <#if carinfoservice.getonecarinfobycarid(car.id)??> <strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).numberseat}</strong></#if>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Doors</span>

                                    <#if carinfoservice.getonecarinfobycarid(car.id)??> <strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).doors}</strong></#if>
                                </div>
                            </li>

                            <li class="list-group-item">
                                <div class="clearfix">
                                    <span class="pull-left">Color</span>

                                     <#if carinfoservice.getonecarinfobycarid(car.id)??><strong class="pull-right">${carinfoservice.getonecarinfobycarid(car.id).color}</strong></#if>
                                </div>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="section-heading">
                        <h2>Vehicle Description</h2>
                    </div>

                    <div class="left-content">
                        <#if car.description??>
                            ${car.description}
                        <#else>
                            <p>No has description.</p>
                        </#if>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="section-heading">
                        <h2>Vehicle Extras</h2>
                    </div>

                    <div class="left-content">
                        <#if carExtractService.findcarextractbycarid(car.id)?size gt 0>
                            <#list carExtractService.findcarextractbycarid(car.id) as carextract>
                                <p>- ${carextract.extract} <br></p>
                            </#list>
                        <#else>
                            <p>No has extract.</p>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="section-heading">
                        <h2>Contact Details</h2>
                    </div>

                    <div class="left-content">
                        <p>
                            <span>Name</span>

                            <br>

                            <strong>John Smith</strong>
                        </p>

                        <p>
                            <span>Phone</span>

                            <br>

                            <strong>
                                <a href="tel:123-456-789">123-456-789</a>
                            </strong>
                        </p>

                        <p>
                            <span>Mobile phone</span>

                            <br>

                            <strong>
                                <a href="tel:456789123">456789123</a>
                            </strong>
                        </p>

                        <p>
                            <span>Email</span>

                            <br>

                            <strong>
                                <a href="mailto:john@carsales.com">john@carsales.com</a>
                            </strong>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</@common.page>