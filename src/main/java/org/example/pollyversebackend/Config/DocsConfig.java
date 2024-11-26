package org.example.pollyversebackend.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition
        (info = @Info(title = "PolyVerse Backend Api",
                                description = "This Api is For Backend API's",
                                summary = "API Contains Summary Info",
                                termsOfService = "Term&Condition Applied..",
                                contact = @Contact(name = "Developed By Jeet-Codes",url = "https://github.com/Jeet-Codes"),
                                version = "v1",
                                license = @License(name = "MIT Licence 1.0")
            )
        )
        // An Update Check

public class DocsConfig {

}
