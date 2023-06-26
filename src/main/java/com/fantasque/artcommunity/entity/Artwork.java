package com.fantasque.artcommunity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName artwork
 */
@TableName(value ="artwork")
@Data
public class Artwork implements Serializable {
    /**
     * 作品id
     */
    @TableId(type = IdType.AUTO)
    private Integer artworkid;

    /**
     * 作者id
     */
    private Integer userid;

    /**
     * 作品标题
     */
    private String artworktitle;

    /**
     * 作品介绍
     */
    private String artworkcomment;

    /**
     * 作品url地址
     */
    private String artworkaddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Artwork other = (Artwork) that;
        return (this.getArtworkid() == null ? other.getArtworkid() == null : this.getArtworkid().equals(other.getArtworkid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getArtworktitle() == null ? other.getArtworktitle() == null : this.getArtworktitle().equals(other.getArtworktitle()))
            && (this.getArtworkcomment() == null ? other.getArtworkcomment() == null : this.getArtworkcomment().equals(other.getArtworkcomment()))
            && (this.getArtworkaddress() == null ? other.getArtworkaddress() == null : this.getArtworkaddress().equals(other.getArtworkaddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArtworkid() == null) ? 0 : getArtworkid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getArtworktitle() == null) ? 0 : getArtworktitle().hashCode());
        result = prime * result + ((getArtworkcomment() == null) ? 0 : getArtworkcomment().hashCode());
        result = prime * result + ((getArtworkaddress() == null) ? 0 : getArtworkaddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", artworkid=").append(artworkid);
        sb.append(", userid=").append(userid);
        sb.append(", artworktitle=").append(artworktitle);
        sb.append(", artworkcomment=").append(artworkcomment);
        sb.append(", artworkaddress=").append(artworkaddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Artwork() {
    }

    public Artwork(Integer artworkid, Integer userid, String artworktitle, String artworkcomment, String artworkaddress) {
        this.artworkid = artworkid;
        this.userid = userid;
        this.artworktitle = artworktitle;
        this.artworkcomment = artworkcomment;
        this.artworkaddress = artworkaddress;
    }
}