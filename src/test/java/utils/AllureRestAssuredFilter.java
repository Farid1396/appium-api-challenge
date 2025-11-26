package utils;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.io.ByteArrayInputStream;

public class AllureRestAssuredFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification request,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        Response response = ctx.next(request, responseSpec);

        Allure.addAttachment(
                "API Request",
                new ByteArrayInputStream(request.getBody() != null ?
                        request.getBody().toString().getBytes() :
                        "No body".getBytes())
        );

        Allure.addAttachment(
                "API Response",
                new ByteArrayInputStream(response.getBody().asByteArray())
        );

        return response;
    }
}
