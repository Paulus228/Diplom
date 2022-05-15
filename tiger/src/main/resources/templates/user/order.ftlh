<#import "../patterns/common.ftlh" as common>
<#include "../patterns/creaditionals.ftlh"/>

<@common.page>
    <div class="send-message" style="margin-top: 0px">
    <p style="text-align: left;padding-top: 120px"></p>
        <div class="container" style="margin-bottom: 80px;">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-heading">
                        <h2>Order now:</h2>
                        <p>Order for car - ${carService.getonecar(id_car?number).name}</p>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="contact-form">
                        <form id="contact" action="/basket/order/${id_car}/${currentUserId}/${id}" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <fieldset>
                                        <input name="name" minlength="5" maxlength="45" type="text" class="form-control" id="name" placeholder="Name" required="required">
                                    </fieldset>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <fieldset>
                                        <input name="soname" minlength="5" maxlength="45" type="text" class="form-control" id="soname" placeholder="Soname" required="required">
                                    </fieldset>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <fieldset>
                                        <input name="faname" minlength="5" maxlength="45" type="text" class="form-control" id="soname" placeholder="Soname" required="required">
                                    </fieldset>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <fieldset>
                                        <input name="priceorder" value="${carService.getonecar(id_car?number).price}" minlength="5" maxlength="45" type="text" class="form-control" id="priceorder" placeholder="Price order" readonly="readonly">
                                    </fieldset>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <fieldset>
                                        <input name="country" minlength="4" maxlength="36" type="text" class="form-control" id="country" placeholder="Country" required="required">
                                    </fieldset>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <fieldset>
                                        <input name="city" minlength="5" maxlength="40" type="text" class="form-control" id="city" placeholder="City" required="required">
                                    </fieldset>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <fieldset>
                                        <input name="address" minlength="20" maxlength="255" type="text" class="form-control" id="address" placeholder="Address" required="required">
                                    </fieldset>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <fieldset>
                                        <input name="contactphone" minlength="10" maxlength="25" type="text" class="form-control" id="contactphone" placeholder="Contact phone" required="required">
                                    </fieldset>
                                </div>
                                <div class="col-lg-12">
                                    <fieldset>
                                        <textarea name="commentorder" minlength="20" maxlength="255" rows="6" class="form-control" id="message" placeholder="Your comment" required="required"></textarea>
                                    </fieldset>
                                </div>
                                <div class="col-lg-12">
                                    <fieldset>
                                        <button type="submit" id="form-submit" class="filled-button">Order</button>
                                    </fieldset>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-4" >
                    <img src="/static/users/img/team_01.jpg" class="img-fluid" alt="">

                    <h5 class="text-center" style="margin-top: 15px;">Our Chef - John Doe</h5>
                </div>

</@common.page>