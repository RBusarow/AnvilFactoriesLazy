package com.reproducer;

import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerMyComponent implements MyComponent {
  private Provider<String> stringProvider;

  private Provider<InjectClass> injectClassProvider;

  private DaggerMyComponent(String stringParam) {

    initialize(stringParam);
  }

  public static MyComponent.Factory factory() {
    return new Factory();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final String stringParam) {
    this.stringProvider = InstanceFactory.create(stringParam);
    this.injectClassProvider = InjectClass_Factory.create(stringProvider, stringProvider);
  }

  @Override
  public Provider<InjectClass> getIc() {
    return injectClassProvider;
  }

  private static final class Factory implements MyComponent.Factory {
    @Override
    public MyComponent create(String string) {
      Preconditions.checkNotNull(string);
      return new DaggerMyComponent(string);
    }
  }
}
