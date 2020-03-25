package models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class Map {

    @Builder.Default
    @NonNull
    private Map_settings map_settings = Map_settings.builder().build();

    @Builder.Default
    private String visibility = "private";

    @Builder.Default
    private String description = "The description about your map goes here";

    @NonNull
    private String title;

    private String picture;
}

@Data
@Builder(toBuilder = true)
class Map_settings {

    @Builder.Default
    private Boolean respotting_to_this_map = true;

    @Builder.Default
    private List<String> editor_access = Arrays.asList("can_administer.map", "can_administer.comments");

    @Builder.Default
    private List<String> visitor_access = Arrays.asList("can_administer.map", "can_administer.comments");
}


