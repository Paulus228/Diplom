<#import "../patterns/common.ftlh" as common>

<@common.page>
    <!-- Page Content -->
    <div class="page-heading about-heading header-text"
         style="background-image: url(/static/users/img/heading-6-1920x500.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="text-content">
                        <h4>Lorem ipsum dolor sit amet</h4>
                        <h2>Cars</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="products">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="contact-form">
                        <form action="#">
                            <label>Used/New:</label>

                            <select class="form-control">
                                <option value="">All</option>
                                <option value="new">New vehicle</option>
                                <option value="used">Used vehicle</option>
                            </select>

                            <label>Vehicle Type:</label>

                            <select class="form-control">
                                <option value="">--All --</option>
                                <option value="">--All --</option>
                                <option value="">--All --</option>
                                <option value="">--All --</option>
                                <option value="">--All --</option>
                            </select>

                            <label>Make:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <label>Model:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <label>Price:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <label>Mileage:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <label>Engine size:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <label>Power:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <label>Fuel:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <label>Gearbox:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <label>Doors:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <label>Number of seats:</label>

                            <select class="form-control">
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                                <option value="">-- All --</option>
                            </select>

                            <button type="submit" class="filled-button btn-block">Search</button>
                        </form>
                    </div>
                </div>

                <div class="col-md-9">
                    <div id="cars" class="row">
                        <#list carlist as car>
                            <div class="col-md-6">
                                <div class="product-item">
                                    <a href="car-details.html">
                                        <#if carphotoservice.findallByidCar(car.id)?size gt 0>
                                            <img src="${carphotoservice.findallByidCar(car.id)[0].photourl}"
                                                 alt="${car.name}">
                                        <#else>
                                            <img src="/static/users/img/product-1-370x270.jpg" alt="${car.name}">
                                        </#if>
                                    </a>
                                    <div class="down-content">
                                        <a href="car-details.html"><h4>${car.name}
                                                - ${carinfoservice.getonecarinfobycarid(car.id).model}</h4></a>
                                        <h6><small>
                                                <del> $${car.price}</del>
                                            </small> $${car.price-120}</h6>

                                        <p>${carinfoservice.getonecarinfobycarid(car.id).power} hp
                                            &nbsp;/&nbsp; ${carinfoservice.getonecarinfobycarid(car.id).fuel}
                                            &nbsp;/&nbsp; ${carinfoservice.getonecarinfobycarid(car.id).first_reg}
                                            &nbsp;/&nbsp; ${carinfoservice.getonecarinfobycarid(car.id).model}</p>
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
                                    </div>
                                </div>
                            </div>
                        </#list>
                        <div class="col-md-12">
                            <ul class="pages">
                                <li><a href="#">1</a></li>
                                <li class="active"><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#"><i class="fa fa-angle-double-right"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>



</@common.page>