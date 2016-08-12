/*
 * Copyright 2016 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package org.maxur.ldoc;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.sun.javadoc.RootDoc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Living Documentation doclet.
 *
 * @author myunusov
 * @version 1.0
 * @since <pre>07.08.2016</pre>
 */
public class LivingDocumentation {

    /**
     * Start boolean.
     *
     * @param root the root
     * @return the boolean
     */
    public static boolean start(final RootDoc root) {
        final LivingDocumentation livingDocumentation = new LivingDocumentation();
        livingDocumentation.writeGlossary(root);
        return true;
    }

    /**
     * Create models list.
     *
     * @param root the root
     * @return the list
     */
    private List<GlossaryModel> glossaryModels(final RootDoc root) {
        return Arrays.stream(root.specifiedPackages())
            .map(GlossaryModel::makeBy)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }

    /**
     * Write glossary.
     *
     */
    private void writeGlossary(final RootDoc root) {
        for (GlossaryModel model : glossaryModels(root)) {
            try {
                final Handlebars handlebars = new Handlebars();
                final Path file = Paths.get(model.getName() + "-glossary.md");
                final Template template = handlebars.compile("glossary");
                byte[] bytes = template.apply(model).getBytes(Charset.forName("UTF-8"));
                Files.write(file, bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}