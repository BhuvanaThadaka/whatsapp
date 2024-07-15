package com.rajlee.creatingwhatsappapi.model;

public record RequestMedia(
        String messaging_product,
        String recipient_type,
        String to,
        String type,
        RequestMediaId image
) {


}
