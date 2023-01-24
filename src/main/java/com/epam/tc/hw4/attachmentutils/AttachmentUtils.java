package com.epam.tc.hw4.attachmentutils;

import io.qameta.allure.Attachment;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtils {

    @Attachment(type = "image/png", value = "try to use param {name}")
    public byte[] makeScreenshotAttachment(final String name, final byte[] screenshot) {
        return screenshot;
    }
}
