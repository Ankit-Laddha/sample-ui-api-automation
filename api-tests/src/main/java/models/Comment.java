package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Comment {

    @Builder.Default
    private String body = "Adding a new comment";

}
