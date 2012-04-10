/* 
 *  Copyright 2012 Ericsson AB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.ericsson.tools.cpp.compiler.osx.linking.executables;

import org.apache.maven.plugin.logging.Log;
import com.ericsson.tools.cpp.compiler.dependencies.DependencyExtractor;
import com.ericsson.tools.cpp.compiler.linking.executables.AbstractGccExecutableLinker;
import com.ericsson.tools.cpp.compiler.linking.executables.Executable;
import com.ericsson.tools.cpp.compiler.settings.CompilationSettings;

import com.ericsson.tools.cpp.tools.environment.Environment;


public class OSX32ExecutableLinker extends AbstractGccExecutableLinker {

	public OSX32ExecutableLinker(final Log log, final CompilationSettings settings, final Environment targetEnvironment, final Executable executable, final DependencyExtractor extractor) {
		super(log, settings, targetEnvironment, executable);
	}
	
	@Override
	protected String getMandatoryLinkerArguments() {
		return super.getMandatoryLinkerArguments() + " -m32";
	}

        @Override
	protected String getStartGroupArgument() {
		// --start-group is not supported by gcc in OS X 10.7
                return "";//-Wl,--start-group";
	}

        @Override
	protected String getEndGroupArgument() {
		// --end-group is not supported by gcc in OS X 10.7
		return "";//-Wl,--end-group";
	}
}
