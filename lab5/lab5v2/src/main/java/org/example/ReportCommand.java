package org.example;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ReportCommand extends Command {
    @Override
    public void execute(List<String> arguments) throws CommandException {
        if(arguments.size() != 0) {
            throw new CommandException("no arguments, syntax: report");
        }

        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setClassForTemplateLoading(ReportCommand.class, "/templates");

            Template template = cfg.getTemplate("report_template.ftl");

            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("repository", "Repository1");

            StringWriter out = new StringWriter();
            template.process(dataModel, out);

            String reportFile = "report.html";
            try (Writer fileWriter = new FileWriter(reportFile)) {
                fileWriter.write(out.toString());
            }

            Desktop.getDesktop().browse(new File(reportFile).toURI());
        } catch (IOException | TemplateException e) {
            throw new CommandException("Error generating report: " + e.getMessage());
        }

    }
}
