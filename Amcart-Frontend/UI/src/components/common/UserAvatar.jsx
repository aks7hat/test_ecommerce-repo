import React from "react";
import "./UserAvatar.css";

const UserAvatar = ({ username }) => {

  const getInitials = (name) => {
    const nameParts = name != null ? name.trim().split(" ") : "welcome";
    const initials =
      nameParts.length > 1
        ? nameParts[0][0] + nameParts[1][0]
        : nameParts[0][0];
    return initials.toUpperCase();
  };

  return (
    <div className="avatar hover:text-[#ffa500]">
      <span>{getInitials(username)}</span>
    </div>
  );
};

export default UserAvatar;
