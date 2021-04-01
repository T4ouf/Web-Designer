workspace "Web-Designer"
	architecture "x64"

	configurations
	{
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

	files
	{
		"%{prj.name}/src/**.h",
		"%{prj.name}/src/**.hpp",
		"%{prj.name}/src/**.cpp",
		"%{prj.name}/src/**.c"
	}

	includedirs
	{
		"%{prj.name}/src"
	}

	
	filter "system:windows"
		cppdialect "C++17"
		systemversion "latest"

		defines
		{
			
		}

		postbuildcommands
		{
			
		}

	filter "configurations:Debug"
		defines {
			"WD_DEBUG",
		}
		runtime "Debug"
		symbols "On"

	filter "configurations:Release"
		defines "WD_RELEASE"
		runtime "Release"
		optimize "On"