# Getting Started with OSGi Remote Services - PDE Edition
This repository contains the sources for the [Getting Started with OSGi Remote Services - PDE Edition](http://blog.vogella.com/?p=7983) blog post.

The blog post and the sources in this repository cover the following topics:
- OSGi Remote Services basics with ECF (Eclipse Communication Framework)
- Remote Service with the ECF Generic Distribution Provider and JmDNS Discovery
- Remote Service with the ECF JAX-RS Distribution Provider and JmDNS Discovery
- Remote Service with the ECF JAX-RS Distribution Provier and EDEF file-based Discovery

In this variant of the blog post Eclipse PDE is used to follow the tutorial or edit and build the sources.

Additionally the sources in this repository contain:
- A Maven Tycho build that produces single executable jar files for the remote services runtimes. More information on that can be found in the [Building a “headless RCP” application with Tycho](http://blog.vogella.com/2020/01/20/building-a-headless-rcp-application-with-tycho/) blog post
- An Eclipse 4 based UI application that consumes the remote services. It contains a service that is used to programmatically bind and unbind a remote service via the ECF EDEF integration.