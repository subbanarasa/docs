/*
 * Copyright 2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: MIT-0
 */

package com.amazonaws.services.kinesis.samples.datavis.utils;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.RegionUtils;

/**
 * A collection of utilities for the Amazon Kinesis sample application.
 */
public class SampleUtils {

    /**
     * Creates a new client configuration with a uniquely identifiable value for this sample application.
     * 
     * @param clientConfig The client configuration to copy.
     * @return A new client configuration based on the provided one with its user agent overridden.
     */
    public static ClientConfiguration configureUserAgentForSample(ClientConfiguration clientConfig) {
        ClientConfiguration newConfig = new ClientConfiguration(clientConfig);
        StringBuilder userAgent = new StringBuilder(ClientConfiguration.DEFAULT_USER_AGENT);

        // Separate regions of the UserAgent with a space
        userAgent.append(" ");
        // Append the repository name followed by version number of the sample
        userAgent.append("amazon-kinesis-data-visualization-sample/1.1.2");

        newConfig.setUserAgent(userAgent.toString());

        return newConfig;
    }

    /**
     * Creates a Region object corresponding to the AWS Region. If an invalid region is passed in
     * then the JVM is terminated with an exit code of 1.
     * 
     * @param regionStr the common name of the region for e.g. 'us-east-1'.
     * @return A Region object corresponding to regionStr.
     */
    public static Region parseRegion(String regionStr) {
        Region region = RegionUtils.getRegion(regionStr);

        if (region == null) {
            System.err.println(regionStr + " is not a valid AWS region.");
            System.exit(1);
        }
        return region;
    }

}
