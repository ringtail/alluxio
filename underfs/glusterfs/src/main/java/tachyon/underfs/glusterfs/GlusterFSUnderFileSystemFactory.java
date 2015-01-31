package tachyon.underfs.glusterfs;

import com.google.common.base.Preconditions;

import tachyon.conf.TachyonConf;
import tachyon.underfs.UnderFileSystem;
import tachyon.underfs.UnderFileSystemFactory;

public class GlusterFSUnderFileSystemFactory implements UnderFileSystemFactory {

  @Override
  public boolean supportsPath(String path, TachyonConf conf) {
    if (path == null) {
      return false;
    }

    return path.startsWith(GlusterFSUnderFileSystem.SCHEME);
  }

  @Override
  public UnderFileSystem create(String path, TachyonConf tachyonConf, Object conf) {
    Preconditions.checkArgument(path != null, "path may not be null");

    return new GlusterFSUnderFileSystem(path, tachyonConf, conf);
  }

}
