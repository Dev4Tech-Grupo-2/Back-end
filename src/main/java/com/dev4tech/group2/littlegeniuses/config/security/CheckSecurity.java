package com.dev4tech.group2.littlegeniuses.config.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public @interface CheckSecurity {

    @interface Students {

        @PreAuthorize("hasAuthority('SCOPE_READ')and hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface CanConsult {
        }

        @PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        @interface CanEdit {
        }

    }

    @interface Teachers {

        @PreAuthorize("hasAuthority('SCOPE_READ')and hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface CanConsult {
        }

        @PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        @interface CanEdit {
        }

    }

    @interface Classes {

        @PreAuthorize("hasAuthority('SCOPE_READ')and hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface CanConsult {
        }

        @PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        @interface CanEdit {
        }

    }

    @interface Users {

        @PreAuthorize("hasAuthority('SCOPE_READ')and hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface CanConsult {
        }

        @PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('ADMIN')")
        @Retention(RUNTIME)
        @Target(METHOD)
        @interface CanEdit {
        }

    }

}
