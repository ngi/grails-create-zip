package createzip

class CreateZipTagLib {

	def zipdirectory = { attrs, body ->
		def dir = attrs.remove('dir')
		def filename = attrs.remove('filename')
		
		out << g.link(controller: "zip",
			action: "directory",  params: [dir: dir, filename: filename])
	}
}
