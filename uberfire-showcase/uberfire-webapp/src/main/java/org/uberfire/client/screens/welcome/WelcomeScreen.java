/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.client.screens.welcome;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import org.uberfire.client.annotations.WorkbenchContextId;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.ext.widgets.core.client.tree.FSTreeItem;
import org.uberfire.ext.widgets.core.client.tree.Tree;
import org.uberfire.ext.widgets.core.client.tree.TreeItem;

@Dependent
@WorkbenchScreen(identifier = "welcome")
public class WelcomeScreen
        extends Composite {

    private static ViewBinder uiBinder = GWT.create(ViewBinder.class);

    @UiField
    FlowPanel container;

    private Tree<FSTreeItem> tree;

    @PostConstruct
    public void init() {
        initWidget(uiBinder.createAndBindUi(this));
        buildATree();
    }

    private void buildATree() {

        tree = new Tree<>();
        container.add(tree.asWidget());


        // final FSTreeItem root = new FSTreeItem(FSTreeItem.FSType.ROOT, "root");
        // final FSTreeItem item1 = new FSTreeItem(FSTreeItem.FSType.ITEM, "item1");
        // root.addItem(item1);
        // tree.addItem(root);
        final FSTreeItem folder1 = new FSTreeItem(FSTreeItem.FSType.FOLDER, "folder1");
        tree.addItem(folder1);
        // root.setState(TreeItem.State.OPEN, false);
        final FSTreeItem item11 = new FSTreeItem(FSTreeItem.FSType.ITEM, "item11");
        folder1.addItem(item11);


        tree.addSelectionHandler(new SelectionHandler<FSTreeItem>() {
            @Override
            public void onSelection(SelectionEvent<FSTreeItem> event) {
                GWT.log("****** SELECTION");
            }
        });

        tree.addOpenHandler(new OpenHandler<FSTreeItem>() {
            @Override
            public void onOpen(OpenEvent<FSTreeItem> event) {
                GWT.log("****** OPEN");
            }
        });

        tree.addCloseHandler(new CloseHandler<FSTreeItem>() {
            @Override
            public void onClose(CloseEvent<FSTreeItem> event) {
                GWT.log("****** CLOSE");
            }
        });


    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Welcome";
    }

    @WorkbenchContextId
    public String getMyContextRef() {
        return "welcomeContext";
    }

    interface ViewBinder
            extends
            UiBinder<Widget, WelcomeScreen> {

    }
}
