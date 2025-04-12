package com.backend.basetest;

import com.backend.util.ReportZipper;
import com.backend.util.SimpleEmailSender;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;
import java.util.Properties;


/**
 * @author Suresh
 * @since 2025-04-12
 */
public abstract class AbstractApiTest {

    protected static final Properties props = new Properties();

    /**
     * Run once before all the test cases
     */
    @BeforeAll
    static void setupBase() {
        String env = System.getProperty("env", "dev");
        try {
            props.load(AbstractApiTest.class.getClassLoader().getResourceAsStream("config/" + env + ".properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config for env: " + env, e);
        }
    }

    /**
     * Runs after all test cases
     */
    @AfterAll
    static void sendReport() {
        try {
            String reportPath = "build/reports/tests/test";
            String zipPath = "build/reports/test-report.zip";

            ReportZipper.zipReportFolder(reportPath, zipPath);
            File zipFile = new File(zipPath);

            SimpleEmailSender.sendHtmlReport("from-address","to-address", zipFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
