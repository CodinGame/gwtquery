package com.google.gwt.query.client.plugins.widgets;

import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Button;

/**
 * Factory used to create a {@link Button} widget. A {@link Button} is created
 * if the element is a <i>button</i>, <i>div></i>, <i>span</i> or <i>a</i>
 * element (should be extends to other element).
 */
public class ButtonWidgetFactory implements WidgetFactory<Button> {

  public Button create(Element e) {

    if ("button".equalsIgnoreCase(e.getTagName())) {
      return Button.wrap(e);
    }

    if (WidgetsUtils.matchesTags(e, "div", "span", "a")) {
      ButtonElement buttonElement = Document.get().createPushButtonElement();
      
      WidgetsUtils.replace(e, buttonElement);

      Button b = Button.wrap(buttonElement);
      b.setHTML(e.getInnerHTML()); // maybe use setText and getInnerText

      return b;
    }

    return null;
  }
}