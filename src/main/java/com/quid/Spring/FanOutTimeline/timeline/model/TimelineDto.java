package com.quid.Spring.FanOutTimeline.timeline.model;

import lombok.Builder;

@Builder
public record TimelineDto(String memberName, String title, String content, Long articleId) {

}
