package com.bandebraia.braiaLocalizerbackend.exceptions;

import com.bandebraia.braiaLocalizerbackend.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
