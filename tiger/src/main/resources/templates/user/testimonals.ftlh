<#import "../patterns/common.ftlh" as common>

<@common.page>
    <div class="page-heading about-heading header-text"
         style="background-image: url(/static/users/img/heading-3-1920x500.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="text-content">
                        <h4>Dolore doloribus sint</h4>
                        <h2>Testimonials</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="services section-background">
        <div class="container">
            <#if testimonals?size gt 0>
            <div class="row">
                <#list testimonals as testi>
                <div class="col-md-4">
                    <div class="service-item">
                        <div class="icon">
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="down-content">
                            <h4>${testi.fullname}</h4>
                            <p class="n-m"><em>"${testi.message_testimonals}"</em></p>
                        </div>
                    </div>
                </div>
                </#list>
                <#else>
                    <p style="text-align: center">Testimonals no has yet!</p>
                </#if>

            </div>
        </div>
    </div>

</@common.page>
