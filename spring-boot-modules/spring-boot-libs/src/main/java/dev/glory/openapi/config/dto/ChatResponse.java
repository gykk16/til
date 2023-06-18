package dev.glory.openapi.config.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChatResponse {

    private List<Choice> choices;

    public record Choice(int index, Message message) {

    }
}
