package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class TrelloBadgesDto {
    private int votes;
    private TrelloAttachmentsByTypeDto attachmentsByType;
}
