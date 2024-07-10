package com.rajlee.creatingwhatsappapi.model;

public record RequestMessage(
        String messaging_product,
        String to,
        RequestMessageText text
) {
}