package com.ofben.autordemo.spring.path.named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Action")
public class ActionMovieCatalog implements MovieCatalog {
    // ...
}