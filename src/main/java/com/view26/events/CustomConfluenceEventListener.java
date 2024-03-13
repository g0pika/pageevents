package com.view26.events;

import com.atlassian.confluence.event.events.content.page.PageCreateEvent;
import com.atlassian.confluence.event.events.content.page.PageViewEvent;
import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import org.springframework.stereotype.Component;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CustomConfluenceEventListener  {

    @ComponentImport
    @Autowired
    private EventPublisher eventPublisher;

    private static final Logger logger = LoggerFactory.getLogger(CustomConfluenceEventListener.class);

    @PostConstruct
    public void init() {
        eventPublisher.register(this);
        logger.debug("CustomConfluenceEventListener initialized");

    }

    @PreDestroy
    public void destroy() {
        eventPublisher.unregister(this);
        logger.debug("CustomConfluenceEventListener destroyed");
    }

    @SuppressWarnings("unused")
    @EventListener
    public void onPageCreateEvent(PageCreateEvent event) {
        logger.debug("Page create event triggered. Page ID: {}", event.getPage().getId());
        storeEvent("create", event.getPage().getId());
    }

    @SuppressWarnings("unused")
    @EventListener
    public void onPageViewEvent(PageViewEvent event) {
        logger.debug("Page view event triggered. Page ID: {}", event.getPage().getId());
        storeEvent("view", event.getPage().getId());
    }

    private void storeEvent(String eventType, long pageId) {
        // Example method to store event in AO. Implement based on your AO entity.
    }
}
