(function ($) {
    "use strict";

    // Event listener for form submission
    $("#contactForm").on("submit", function (event) {
        event.preventDefault(); // Prevent default form submission behavior

        // Collect form data
        var formData = {
            username: $("input[name='username']").val(),
            password: $("input[name='password']").val(),
            email: $("input[name='email']").val(),
            firstName: $("input[name='firstName']").val(),
            lastName: $("input[name='lastName']").val()
        };

        // Send POST request to Spring controller
        $.ajax({
            type: "POST",
            url: "/auth/register", // Endpoint of your Spring controller
            contentType: "application/json", // Set content type to JSON
            data: JSON.stringify(formData), // Convert form data to JSON
            success: function(response) {
                // Handle successful response
                console.log("Registration successful:", response);
                // Optionally, reset the form or show a success message
            },
            error: function(xhr, status, error) {
                // Handle error response
                console.error("Registration error:", error);
                // Optionally, display an error message to the user
            }
        });
    });

}(jQuery));











