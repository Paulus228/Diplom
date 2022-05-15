<#import "../patterns/common.ftlh" as common>
<#include "../patterns/creaditionals.ftlh"/>

<@common.page>
    <div class="container">
        <p style="text-align: left;font-size: 1.36em;padding-top: 120px ">Basket user: <strong>${name}</strong></p>
        <hr>
        <br/>
    <div class="table-responsive">
        <table class="table" >
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Car</th>
                <th scope="col">Model</th>
                <th scope="col">Price</th>
                <th scope="col">Car date added</th>
                <th scope="col">Checkout order</th>
                <th scope="col">Status order</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <#if basketlist?size gt 0>
            <#list basketlist as bl>
            <tr>
                <th scope="row">${bl?index+1}</th>
                <td><a href="/cars/${bl.id_car}">${carservice.getonecar(bl.id_car).name}</a></td>
                <td><a href="/cars/${bl.id_car}">${carservice.getonecar(bl.id_car).name}</a></td>
                <td><strong>${carservice.getonecar(bl.id_car).price}</strong></td>
                <td>${carservice.getonecar(bl.id_car).date_add}</td>
                <td><a href="#" class="btn btn-dark">Order now</a></td>
                <td>In Process</td>
                <td><a class="btn btn-danger" href="/basket/delete/${bl.id_car}/${currentUserId}/${bl.id}">Delete</a></td>
            </tr>
            </#list>
                <#else>
                <tr>
                    <td>No has car in basket yet!</td>
                </tr>
            </#if>
            </tbody>
        </table>
    </div>
    </div>
</@common.page>