package dg2.dmi.com.dagger2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by gguser on 1/29/16.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
