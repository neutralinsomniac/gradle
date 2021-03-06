/*
 * Copyright 2016 the original author or authors.
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

package org.gradle.internal.execution.history.changes;

import com.google.common.collect.ImmutableSortedMap;
import org.gradle.internal.change.ChangeVisitor;
import org.gradle.internal.fingerprint.CurrentFileCollectionFingerprint;
import org.gradle.internal.fingerprint.FileCollectionFingerprint;

public class OutputFileChanges extends AbstractFingerprintChanges {

    private final boolean includeAdded;

    public OutputFileChanges(ImmutableSortedMap<String, FileCollectionFingerprint> previous, ImmutableSortedMap<String, CurrentFileCollectionFingerprint> current, boolean includeAdded) {
        super(previous, current, "Output");
        this.includeAdded = includeAdded;
    }

    @Override
    public boolean accept(ChangeVisitor visitor) {
        return accept(visitor, includeAdded);
    }
}
