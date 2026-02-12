package models;

import net.datafaker.Faker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public record Message(String name, String email, String subject, String text, File attachment) {
    public static Message random() {
        var faker = new Faker();
        return new Message(
                faker.name().fullName(),
                faker.internet().safeEmailAddress(),
                faker.internet().emailSubject(),
                faker.text().text(),
                createRandomPngFile(faker)
        );
    }

    private static File createRandomPngFile(Faker faker) {
        try {
            var tempFile = Files.createTempFile("test", ".png").toFile();
            tempFile.deleteOnExit();
            var base64Image = faker.image().base64PNG();
            var base64Data = base64Image.contains(",")
                    ? base64Image.split(",")[1]
                    : base64Image;
            var imageBytes = Base64.getDecoder().decode(base64Data);

            try(FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(imageBytes);
            }
            return tempFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
