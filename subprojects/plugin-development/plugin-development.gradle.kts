/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.gradle.gradlebuild.testing.integrationtests.cleanup.WhenNotEmpty
import org.gradle.gradlebuild.unittestandcompile.ModuleType

plugins {
    gradlebuild.`strict-compile`
    gradlebuild.classycle
}

dependencies {
    compile(library("groovy"))
    compile(project(":core"))
    compile(project(":plugins"))
    compile(project(":publish"))
    compile(project(":maven"))
    compile(project(":ivy"))
    testRuntime(project(":toolingApi"))
    testRuntime(project(":launcher"))
    testRuntime(project(":testKit"))
    integTestRuntime(project(":toolingApiBuilders"))
}

gradlebuildJava {
    moduleType = ModuleType.CORE
}

testFixtures {
    from(":core")
    from(":logging")
}

testFilesCleanup {
    policy.set(WhenNotEmpty.REPORT)
}
