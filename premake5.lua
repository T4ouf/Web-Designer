workspace "Web-Designer"
	-- Web Designer is built for X64 systems
	architecture "x64"

	configurations {
		"Debug",
		"Release"
	}

	startproject "Web-Designer"

outputdir = "%{cfg.buildcfg}-%{cfg.system}-%{cfg.architecture}"

-- Include directories relative to root folder (solution directory)
IncludeDir = {}

group ""

project "Web-Designer"
	location "Web-Designer"
	kind "ConsoleApp"
	language "C++"
	staticruntime "off"

	targetdir ("bin/" .. outputdir .. "/%{prj.name}")
	objdir ("bin-int/" .. outputdir .. "/%{prj.name}")

	pchheader "wdpch.h"
	pchsource "Web-Designer/src/wdpch.cpp"

	files {
		"%{prj.name}/src/**.h",
		"%{prj.name}/src/**.hpp",
		"%{prj.name}/src/**.cpp",
		"%{prj.name}/src/**.c"
	}

	includedirs {
		"%{prj.name}/src"
	}

	
	filter "system:windows"
		cppdialect "C++17"
		systemversion "latest"

		defines {
			"WD_PLATFORM_WINDOWS"
		}

	filter "configurations:Debug"
		defines {
			"WD_DEBUG",
			"WD_ENABLE_ASSERTS"
		}
		runtime "Debug"
		symbols "On"

	filter "configurations:Release"
		defines "WD_RELEASE"
		runtime "Release"
		optimize "On"